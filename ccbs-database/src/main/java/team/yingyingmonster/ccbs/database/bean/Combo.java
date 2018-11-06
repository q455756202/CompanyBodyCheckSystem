package team.yingyingmonster.ccbs.database.bean;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * 套餐表
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Combo {
    private Long comboid;
    private String comboname;
    private String combosummary;
    private Double comboratio;

    @SerializedName("comboCheckList")
    private List<ComboCheck> comboChecksByComboid;
    @SerializedName("teamformCombocheckList")
    private List<TeamformCombocheck> teamformCombochecksByComboid;
}