package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.*;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCombo;
import team.yingyingmonster.ccbs.database.mapper.CompanyMapper;
import team.yingyingmonster.ccbs.database.mapper.TeamformMapper;
import team.yingyingmonster.ccbs.database.mapper.juergenie.*;
import team.yingyingmonster.ccbs.database.bean.juergenie.JuerCompanyCheckEntity;
import team.yingyingmonster.ccbs.json.JsonUtil;
import team.yingyingmonster.ccbs.service.servicebean.Constant;
import team.yingyingmonster.ccbs.service.serviceinterface.JuerCompanyCheckSystemService;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Juer Whang <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 16:36 2018/11/4
 * - 提供团检报名的服务。
 **/
@Service
public class JuerCompanyCheckSystemServiceImplement implements JuerCompanyCheckSystemService {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private JuerComboMapper juerComboMapper;
    @Autowired
    private JuerComboCheckMapper juerComboCheckMapper;
    @Autowired
    private JuerUserMapper juerUserMapper;
    @Autowired
    private JuerUserCheckMapper juerUserCheckMapper;
    @Autowired
    private JuerTeamformMapper juerTeamformMapper;
    @Autowired
    private JuerTeamformCombocheckMapper juerTeamformCombocheckMapper;
    @Autowired
    private JuerBillMapper juerBillMapper;

    /**
     * 获取团检报名用的实体，这个实体用于传输到前台，供前端进行数据操作。
     * @param companyEntity
     * @return
     */
    @Override
    public JuerCompanyCheckEntity getCompanyCheckEntity(Long companyid) {
        JuerCompanyCheckEntity entity = new JuerCompanyCheckEntity();
        entity.setCompany(companyMapper.selectByPrimaryKey(companyid));
        entity.setComboList(juerComboMapper.selectAllJuerCombo());
        User condition = new User();
        condition.setCompanyid(companyid);
        entity.setUserList(juerUserMapper.selectUsersByCondition(condition));

        return entity;
    }

    /**
     * 通过团检报名实体，向数据库插入数据。
     * @param juerCompanyCheckEntity
     * @return
     */
    @Override
    public boolean registerCompanyCheck(JuerCompanyCheckEntity juerCompanyCheckEntity) throws Exception {
        Teamform teamform = new Teamform();
        teamform.setCompanyid(juerCompanyCheckEntity.getCompany().getCompanyid());
        teamform.setTeamformstate(Constant.TEAMFORM_UNDONE);
        teamform.setTeamformid(juerTeamformMapper.getNewId());

        if (juerTeamformMapper.insert(teamform)<1)
            throw new Exception("插入团检数据失败 - juerTeamformMapper.insert");

//        List<TeamformCombocheck> teamformCombocheckList = generatTeamformCombocheckList(juerCompanyCheckEntity.getComboList(), teamform.getTeamformid());
        List<TeamformCombocheck> teamformCombocheckList = new LinkedList<>();
        List<UserCheck> userCheckList = new LinkedList<>();
        List<Bill> billList = new LinkedList<>();

        // 遍历实体中选中的所有套餐
        for (int i = 0; i < juerCompanyCheckEntity.getSelectCombo().size(); i++) {
            JuerCombo combo = juerCompanyCheckEntity.getSelectCombo().get(i);

            // 构建一个团检套餐实体
            TeamformCombocheck combocheck = new TeamformCombocheck();
            combocheck.setTeamformcombocheckid(juerTeamformCombocheckMapper.getNewId());
            combocheck.setComboid(combo.getComboid());
            combocheck.setTeamformid(teamform.getTeamformid());
            teamformCombocheckList.add(combocheck);

            // 获取套餐对应的检查项
            List<Check> checkList = juerComboCheckMapper.selectChecksByComboid(combo.getComboid());

            // 遍历该套餐中的所有用户，并为其构建相应的个人体检实体
            for (int j = 0; j < combo.getUserList().size(); j++) {
                UserCheck userCheck = new UserCheck();
                userCheck.setUserid(combo.getUserList().get(j).getUserid());
                userCheck.setTeamformcombocheckid(combocheck.getTeamformcombocheckid());
                userCheck.setUsercheckid(juerUserCheckMapper.getNewId());
                userCheckList.add(userCheck);

                // 遍历检查项，为每个用户创建相应的记账实体
                for (int k = 0; k < checkList.size(); k++) {
                    Bill bill = new Bill();
                    bill.setUsercheckid(userCheck.getUsercheckid());
                    bill.setBillid(juerBillMapper.getNewId());
                    bill.setCheckid(checkList.get(k).getCheckid());

                    billList.add(bill);
                }
            }
        }

        if (juerTeamformCombocheckMapper.insertBatch(teamformCombocheckList)<1)
            throw new Exception("插入团检数据失败 - juerTeamformCombocheckMapper.insertBatch");
        if (juerUserCheckMapper.insertBatch(userCheckList)<1)
            throw new Exception("插入团检数据失败 - juerUserCheckMapper.insertBatch");
        if (juerBillMapper.insertBatch(billList)<1)
            throw new Exception("插入团检数据失败 - juerBillMapper.insertBatch");

        return true;
    }

    private List<TeamformCombocheck> generatTeamformCombocheckList(List<JuerCombo> list, Long teamformid) {
        List<TeamformCombocheck> result = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            Combo combo = list.get(i);
            TeamformCombocheck combocheck = new TeamformCombocheck();
            combocheck.setComboid(combo.getComboid());
            combocheck.setTeamformid(teamformid);
            result.add(combocheck);
        }
        return result;
    }
}
