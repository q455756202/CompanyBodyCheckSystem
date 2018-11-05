package team.yingyingmonster.ccbs.database.bean;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * 公司表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Company {
    private Long companyid;
    private Long accountid;
    private BigDecimal companyprice;
    private String companyemail;
    private String companyphone;

    // 添加序列化名字，用于在转换json时启用别名。
    @SerializedName("account")
    private Account accountByAccountid;
    @SerializedName("userList")
    private List<User> usersByCompanyid;
    @SerializedName("teamformList")
    private List<Teamform> teamformByCompanyid;
}