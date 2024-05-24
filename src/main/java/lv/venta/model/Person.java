package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "PersonTable")
@Entity
//@Inheritance(strategy = InheritanceType.JOINED) //kopīgās lietas (idpe, name, surname) ir Personas tabulā un atsķirīgas bērnu tabulās
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //viss (Personas, Studenti, professori) būs vienā tabulā
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)//katrai klasei sava tabula, bet bāzes klases tabula ir tukša
public class Person {
	
	@Id
	@Column(name = "Idpe")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Setter(value = AccessLevel.NONE)
	private int idpe;
	
	
	@Column(name = "Name")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Size(min = 3, max = 50)
	@Pattern(regexp = "[A-ZĒŪĪĻĶĢŠĀŽČŅ]{1}[a-zēūīļķģšāžčņ]+", message = "Only letters and space are allowed")
	private String surname;
	
	public Person(String name, String surname) {
		setName(name);
		setSurname(surname);
	}
}