package test.currentprice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

@Entity
public class Currency {

	@Id
	@Size(min = 3, max = 3, message = "請輸入3碼")
	@Column(unique = true, nullable = false)
	private String code;

	@Column(nullable = false)
	private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
