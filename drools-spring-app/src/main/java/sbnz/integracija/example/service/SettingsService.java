package sbnz.integracija.example.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.maven.shared.invoker.DefaultInvocationRequest;
import org.apache.maven.shared.invoker.DefaultInvoker;
import org.apache.maven.shared.invoker.InvocationRequest;
import org.apache.maven.shared.invoker.InvocationResult;
import org.apache.maven.shared.invoker.Invoker;
import org.apache.maven.shared.invoker.MavenInvocationException;
import org.drools.template.ObjectDataCompiler;
import org.kie.api.runtime.KieContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



import sbnz.integracija.example.SampleAppService;
import sbnz.integracija.example.dto.AgeSettingsDTO;
import sbnz.integracija.example.dto.BudgetSettingsDTO;
import sbnz.integracija.example.enums.AgeCategory;
import sbnz.integracija.example.enums.BudgetCategory;
import sbnz.integracija.example.facts.AgeTemplateModel;
import sbnz.integracija.example.facts.BudgetTemplateModel;

@Service
public class SettingsService {
private static Logger log = LoggerFactory.getLogger(SampleAppService.class);
	
	private final KieContainer kieContainer;
	
//	@Value("${sbnz.ta.template.age}")
//    private String ageTemplate;
//	
//	@Value("${sbnz.ta.drl.ageRules}")
//    private String ageDRL;
	
	
	@Autowired
	public SettingsService(KieContainer kieContainer) {
		log.info("Initialising a new session.");
		this.kieContainer = kieContainer;
	}
	
	public void updateAgeCategories(AgeSettingsDTO dto) throws Exception {
		if (dto.getAdultAgeMin() >= dto.getOldAgeMin() || dto.getAdultAgeMin() <= 1 || dto.getOldAgeMin()==0 || dto.getOldAgeMin()>=200) {
			throw new Exception("Invalid values.");
		}
		String ageDRL = "../drools-spring-kjar/src/main/resources/sbnz/ta/ageRules.drl";
		String ageTemplate = "../drools-spring-kjar/src/main/resources/sbnz/ta/template/age.drt";
		
		List<AgeTemplateModel> settings = new ArrayList<AgeTemplateModel>();
		settings.add(new AgeTemplateModel(0, dto.getAdultAgeMin(), AgeCategory.YOUNG));
		settings.add(new AgeTemplateModel(dto.getAdultAgeMin(), dto.getOldAgeMin(), AgeCategory.ADULT));
		settings.add(new AgeTemplateModel(dto.getOldAgeMin(), 200, AgeCategory.OLD));
		
		PrintWriter writer = new PrintWriter(ageDRL);
        writer.print("");
        writer.close();

        InputStream template = new FileInputStream(ageTemplate);
        String drl = (new ObjectDataCompiler()).compile(settings, template);
        Files.write(Paths.get(ageDRL), drl.getBytes(), StandardOpenOption.WRITE);
        
        mavenCleanAndInstall();
	}
	
	public void updateBudgetCategories(BudgetSettingsDTO dto) throws Exception {
		if (dto.getStandardBudgetMin() >= dto.getLuxBudgetMin() || dto.getStandardBudgetMin() <= 1.0 || dto.getLuxBudgetMin()==0.0 || dto.getLuxBudgetMin()>=1000000000.0) {
			throw new Exception("Invalid values.");
		}
		String budgetDRL = "../drools-spring-kjar/src/main/resources/sbnz/ta/budgetRules.drl";
		String budgetTemplate = "../drools-spring-kjar/src/main/resources/sbnz/ta/template/budget.drt";
		
		List<BudgetTemplateModel> settings = new ArrayList<BudgetTemplateModel>();
		settings.add(new BudgetTemplateModel(0.0, dto.getStandardBudgetMin(), BudgetCategory.BUDGET));
		settings.add(new BudgetTemplateModel(dto.getStandardBudgetMin(), dto.getLuxBudgetMin(), BudgetCategory.STANDARD));
		settings.add(new BudgetTemplateModel(dto.getLuxBudgetMin(), Double.MAX_VALUE, BudgetCategory.LUX));

        InputStream template = new FileInputStream(budgetTemplate);
        String drl = (new ObjectDataCompiler()).compile(settings, template);
        Files.write(Paths.get(budgetDRL), drl.getBytes(), StandardOpenOption.WRITE);
        
        mavenCleanAndInstall();
	}
	
	public static void mavenCleanAndInstall() throws MavenInvocationException {
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File("../drools-spring-kjar/pom.xml"));
        request.setGoals(Arrays.asList("clean", "install"));

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M2_HOME")));
        InvocationResult result = invoker.execute(request);
        if (result.getExitCode() != 0) {
            System.out.println(result.getExecutionException().toString());
            System.out.println(result.getExitCode());
        }
	}

}
