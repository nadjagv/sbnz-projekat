package sbnz.integracija.example.facts;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sbnz.integracija.example.enums.BudgetCategory;
import sbnz.integracija.example.enums.DestinationType;
import sbnz.integracija.example.enums.TownProximity;

@Entity
@Table(name = "destinations")
@SQLDelete(sql
        = "UPDATE destinations "
        + "SET deleted = true "
        + "WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Destination {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "deleted", nullable = false)
    private boolean deleted;
    
    @Column(name = "location", nullable = false,unique = true)
	private String location;
    
    @Column(name = "price", nullable = false)
	private BudgetCategory price;
    
    @Column(name = "proximity", nullable = false)
    private TownProximity proximity;
    
    @Column(name = "airport", nullable = false)
    private boolean airport;
    
    @Column(name = "rent_a_car", nullable = false)
    private boolean rentACar;
    
    @Column(name = "beach", nullable = false)
    private boolean beach;
    
    @Column(name = "sightseeings", nullable = false)
    private boolean sightseeings;
    
    @Column(name = "shops", nullable = false)
    private boolean shops;
    
    @Column(name = "restaurants", nullable = false)
    private boolean restaurants;
    
    @Column(name = "children_activities", nullable = false)
    private boolean childrenActivities;
    
    @Column(name = "type", nullable = false)
    private DestinationType destinationType;
    
    @OneToMany(mappedBy = "destination", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Attraction> attractions=new HashSet<Attraction>();
	

}
