package ga.rugal.food.core.entity;

import com.google.gson.annotations.Expose;
import config.SystemDefaultProperties;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

/**
 *
 * @author Rugal Bernstein
 */
@Entity
@Table(schema = "food", name = "menu")
public class Menu extends BaseObject<Menu>
{

    private static final String sequence_name = "menu_mid_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence_name)
    @SequenceGenerator(name = sequence_name,
        sequenceName = SystemDefaultProperties.SCHEMA + sequence_name, allocationSize = 1)
    @Basic(optional = false)
    @Column(nullable = false)
    @Expose
    private Integer mid;

    @Size(max = 50)
    @Column(length = 50)
    @Expose
    private String name;

    @Size(max = 20)
    @Column(length = 20)
    private String image;

    @Column(precision = 6, scale = 2)
    @Expose
    private Double price;

    @Column
    @Expose
    private Integer calory;

    @OneToMany(mappedBy = "menu")
    private List<Tagging> taggingList;

    @Expose
    @Transient
    private List<Tag> tags;

    @JoinColumn(name = "rid", referencedColumnName = "rid")
    @ManyToOne
    @Expose
    private Restaurant restaurant;

    public Menu()
    {
    }

    public Menu(Integer mid)
    {
        this.mid = mid;
    }

    public Integer getMid()
    {
        return mid;
    }

    public Menu setMid(Integer mid)
    {
        this.mid = mid;
        return this;
    }

    public String getImage()
    {
        return image;
    }

    public Menu setImage(String image)
    {
        this.image = image;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public Menu setName(String name)
    {
        this.name = name;
        return this;
    }

    public Double getPrice()
    {
        return price;
    }

    public Menu setPrice(Double price)
    {
        this.price = price;
        return this;
    }

    public Integer getCalory()
    {
        return calory;
    }

    public void setCalory(Integer calory)
    {
        this.calory = calory;
    }

    public List<Tagging> getTaggingList()
    {
        return taggingList;
    }

    public Menu setTaggingList(List<Tagging> taggingList)
    {
        this.taggingList = taggingList;
        return this;
    }

    public List<Tag> getTags()
    {
        return tags;
    }

    public void setTags(List<Tag> tags)
    {
        this.tags = tags;
    }

    public Restaurant getRestaurant()
    {
        return restaurant;
    }

    public Menu setRestaurant(Restaurant restaurant)
    {
        this.restaurant = restaurant;
        return this;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (mid != null ? mid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu))
        {
            return false;
        }
        Menu other = (Menu) object;
        return !((this.mid == null && other.mid != null) || (this.mid != null && !this.mid.equals(other.mid)));
    }

    @Override
    public String toString()
    {
        return "ga.rugal.food.core.entity.Menu[ mid=" + mid + " ]";
    }

    @Override
    protected Class<Menu> getRealClass()
    {
        return Menu.class;
    }

}
