package logistics;

import javax.persistence.*;

@Entity(name="logistics.Address")
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "zip_code_3d")
    private String zipCode3d;

    @Column(name = "postal_code")
    private String postalCode;

    @Column(name = "state_code")
    private String stateCode;

    @Column(name = "city_alias")
    private String cityAlias;

    @Column(name = "location")
    private String location;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getZipCode3d() {
		return zipCode3d;
	}

	public void setZipCode3d(String zipCode3d) {
		this.zipCode3d = zipCode3d;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getCityAlias() {
		return cityAlias;
	}

	public void setCityAlias(String cityAlias) {
		this.cityAlias = cityAlias;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", city=" + city + ", zipCode=" + zipCode + ", zipCode3d=" + zipCode3d
				+ ", postalCode=" + postalCode + ", stateCode=" + stateCode + ", cityAlias=" + cityAlias + ", location="
				+ location + "]";
	}

   

}
