package sbnz.integracija.example.facts;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "reviews")
@SQLDelete(sql
        = "UPDATE reviews "
        + "SET deleted = true "
        + "WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "deleted", nullable = false)
    private boolean deleted;
    
    @Column(name = "rating", nullable = false)
	private Double rating;
    
    @Column(name = "text", nullable = false)
	private String text;
    
    @Column(name = "date", nullable = false)
	private LocalDateTime date;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Attraction attraction;

}
