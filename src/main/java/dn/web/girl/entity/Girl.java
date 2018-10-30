package dn.web.girl.entity;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

/**
 * @Author: 邓宁
 * @Date: Created in 21:49 2018/10/24
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;
    private String size;
    @Min(value = 18,message = "未成年少女禁止入内")
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "size='" + size + '\'' +
                ", age=" + age +
                '}';
    }
}
