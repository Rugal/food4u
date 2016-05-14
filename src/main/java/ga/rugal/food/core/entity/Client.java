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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Rugal Bernstein
 */
@Entity
@Table(schema = "food", name = "client")
public class Client
{

    private static final String sequence_name = "client_cid_seq";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = sequence_name)
    @SequenceGenerator(name = sequence_name,
        sequenceName = SystemDefaultProperties.SCHEMA + sequence_name, allocationSize = 1)
    @Basic(optional = false)
    @Column(nullable = false)
    @Expose
    private Integer cid;

    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @Size(max = 50)
    @Column(length = 50)
    private String credential;

//    @Pattern(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message = "Invalid email")
    @Size(max = 50)
    @Column(length = 50)
    private String email;

    @Size(max = 20)
    @Column(length = 20)
    private String phone;

    @Column
    @Expose
    private Integer height;

    @Column
    @Expose
    private Integer weight;

    @OneToMany(mappedBy = "client")
    private List<Tagging> taggingList;

    public Client()
    {
    }

    public Client(Integer cid)
    {
        this.cid = cid;
    }

    public Integer getCid()
    {
        return cid;
    }

    public Client setCid(Integer cid)
    {
        this.cid = cid;
        return this;
    }

    public String getName()
    {
        return name;
    }

    public Client setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getCredential()
    {
        return credential;
    }

    public Client setCredential(String credential)
    {
        this.credential = credential;
        return this;
    }

    public String getEmail()
    {
        return email;
    }

    public Client setEmail(String email)
    {
        this.email = email;
        return this;
    }

    public Integer getHeight()
    {
        return height;
    }

    public void setHeight(Integer height)
    {
        this.height = height;
    }

    public Integer getWeight()
    {
        return weight;
    }

    public void setWeight(Integer weight)
    {
        this.weight = weight;
    }

    public String getPhone()
    {
        return phone;
    }

    public Client setPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public List<Tagging> getTaggingList()
    {
        return taggingList;
    }

    public Client setTaggingList(List<Tagging> taggingList)
    {
        this.taggingList = taggingList;
        return this;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client))
        {
            return false;
        }
        Client other = (Client) object;
        return !((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid)));
    }

    @Override
    public String toString()
    {
        return "ga.rugal.food.core.entity.Client[ cid=" + cid + " ]";
    }

}
