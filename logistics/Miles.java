package logistics;

import javax.persistence.*;

@Entity(name="logistics.Miles")
@Table(name = "miles")
public class Miles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin")
    private Address origin;

    @ManyToOne
    @JoinColumn(name = "destination")
    private Address destination;

    @Column(name = "miles")
    private Float miles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Address getOrigin() {
		return origin;
	}

	public void setOrigin(Address origin) {
		this.origin = origin;
	}

	public Address getDestination() {
		return destination;
	}

	public void setDestination(Address destination) {
		this.destination = destination;
	}

	public Float getMiles() {
		return miles;
	}

	public void setMiles(Float miles) {
		this.miles = miles;
	}

	@Override
	public String toString() {
		return "Miles [id=" + id + ", origin=" + origin + ", destination=" + destination + ", miles=" + miles + "]";
	}




}
