package team.yingyingmonster.ccbs.service.serviceimplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.yingyingmonster.ccbs.database.bean.User;
import team.yingyingmonster.ccbs.database.mapper.zhw.ZhaoAccountMapper;
import team.yingyingmonster.ccbs.database.mapper.zhw.ZhaoUserMapper;
import team.yingyingmonster.ccbs.service.serviceinterface.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhao Han Wei <br/>
 * - project: CompanyBodyCheckSystem
 * - create: 9:23 2018/11/9
 * - User服务实现类
 **/
@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private ZhaoUserMapper zhaoUserMapper;


    //插入体检人员信息
    @Override
    public Integer insertUsers(Long companyId, List<String[]> userList) {
        Integer result=0;
        User user = new User();
        List<User> users = new ArrayList<User>();
        for (String[] userInfo : userList) {
            Long userId = zhaoUserMapper.getNewUserId();
            user.setUserid(userId);
            user.setCompanyid(companyId);
            user.setUsername(userInfo[0]);
            user.setUsergender((short)(userInfo[1].equals("男")?0:1));
            user.setUserage(Short.valueOf(userInfo[2]));
            user.setUserphone(userInfo[3]);
            user.setUsercardcode(userInfo[4]);
            users.add(user);
        }
        List<User> beforeUsers = new ArrayList<User>();
        beforeUsers=zhaoUserMapper.selectBeforeUsers(companyId);
        for(int i=0; i<beforeUsers.size(); i++){
            for(int j=0;j<users.size();j++){
                if(beforeUsers.get(i).equals(users.get(j).getUsercardcode())){
                    users.remove(users.get(j));
                }
            }
        }
        if (users!=null){
            result = zhaoUserMapper.insertUsers(users);
        }
        System.out.println("插入信息的条数：" + result);
        return result;
    }

    //查询已插入体检人员名单
    @Override
    public List<User> selectUsers(Long companyId) {
        return zhaoUserMapper.selectBeforeUsers(companyId);
    }
}
