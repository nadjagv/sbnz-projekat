package sbnz.integracija.example.facts;

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
import sbnz.integracija.example.enums.AttractionType;

@Entity
@Table(name = "attractions")
@SQLDelete(sql
        = "UPDATE attractions "
        + "SET deleted = true "
        + "WHERE id = ?")
@Where(clause = "deleted = false")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attraction {
	
	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "deleted", nullable = false)
    private boolean deleted;
    
    @Column(name = "name", nullable = false)
	private String name;
    
    @Column(name = "description", nullable = false)
	private String description;
    
    @Column(name = "near_destination", nullable = false)
	private boolean nearDestination;
    
    @Column(name = "tickets", nullable = false)
	private boolean tickets;
    
    @Column(name = "child_friendly", nullable = false)
	private boolean childFriendly;
    
    @Column(name = "type", nullable = false)
	private AttractionType attractionType;
    
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Destination destination;

}
