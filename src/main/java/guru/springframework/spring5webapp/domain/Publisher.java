package guru.springframework.spring5webapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // thrown the responsibility to autoincrement Id in database
    private Long id;

    private String name;
    private String address;
    private String addressLineOne;
    private String city;
    private String state;
    private String zip;

    @OneToMany(mappedBy = "publisher")
    @JoinTable(name = "publisher_author"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> publisherAuthor;

    @OneToMany(mappedBy = "publisher")
    @JoinTable(name = "publisher_book"
            , joinColumns = @JoinColumn(name = "book_id")
            , inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> publisherBook;

    public Publisher(Set<Author> publisherAuthor, Set<Author> publisherBook){
        this.publisherAuthor = publisherAuthor;
        this.publisherBook = publisherBook;
    }

    public Publisher(String name, String address, String addressLineOne, String city, String state, String zip) {
        this.name = name;
        this.address = address;
        this.addressLineOne = addressLineOne;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public void setAddressLineOne(String addressLineOne) {
        this.addressLineOne = addressLineOne;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Set<Author> getPublisherAuthor() {
        return publisherAuthor;
    }

    public void setPublisherAuthor(Set<Author> publisherAuthor) {
        this.publisherAuthor = publisherAuthor;
    }

    public Set<Author> getPublisherBook() {
        return publisherBook;
    }

    public void setPublisherBook(Set<Author> publisherBook) {
        this.publisherBook = publisherBook;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", addressLineOne='" + addressLineOne + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", publisherAuthor=" + publisherAuthor +
                ", publisherBook=" + publisherBook +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        if (id != null ? !id.equals(publisher.id) : publisher.id != null) return false;
        if (name != null ? !name.equals(publisher.name) : publisher.name != null) return false;
        if (address != null ? !address.equals(publisher.address) : publisher.address != null) return false;
        if (addressLineOne != null ? !addressLineOne.equals(publisher.addressLineOne) : publisher.addressLineOne != null)
            return false;
        if (city != null ? !city.equals(publisher.city) : publisher.city != null) return false;
        if (state != null ? !state.equals(publisher.state) : publisher.state != null) return false;
        if (zip != null ? !zip.equals(publisher.zip) : publisher.zip != null) return false;
        if (publisherAuthor != null ? !publisherAuthor.equals(publisher.publisherAuthor) : publisher.publisherAuthor != null)
            return false;
        return publisherBook != null ? publisherBook.equals(publisher.publisherBook) : publisher.publisherBook == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (addressLineOne != null ? addressLineOne.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        result = 31 * result + (publisherAuthor != null ? publisherAuthor.hashCode() : 0);
        result = 31 * result + (publisherBook != null ? publisherBook.hashCode() : 0);
        return result;
    }
}
