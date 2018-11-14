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
        List<User> users = new ArrayList<User>();
        for (int i=0;i<userList.size();i++) {
            User user = new User();
            Long userId = zhaoUserMapper.getNewUserId();
            user.setUserid(userId);
            user.setCompanyid(companyId);
            user.setUsername(userList.get(i)[0]);
            user.setUsergender((short)(userList.get(i)[1].equals("男")?0:1));
            user.setUserage(Short.valueOf(userList.get(i)[2]));
            user.setUserphone(userList.get(i)[3]);
            user.setUsercardcode(userList.get(i)[4]);
            users.add(user);
        }
        List<User> beforeUsers = new ArrayList<User>();
        beforeUsers=zhaoUserMapper.selectBeforeUsers(companyId);
        for(int i=0; i<beforeUsers.size(); i++){
            for(int j=0;j<users.size();j++){
                if((beforeUsers.get(i).getUsercardcode()).equals(users.get(j).getUsercardcode())){
                    users.remove(users.get(j));
                }
            }
        }
        if (users.size()!=0){
            result = zhaoUserMapper.insertUsers(users);
        }
        return result;
    }

    //查询已插入体检人员名单
    @Override
    public List<User> selectUsers(Long companyId) {
        return zhaoUserMapper.selectBeforeUsers(companyId);
    }

    @Override
    public Integer insertUser(Long companyId, User user) {
        Integer result=0;
        List<User> beforeUsers = new ArrayList<User>();
        beforeUsers=zhaoUserMapper.selectBeforeUsers(companyId);
        for(int i=0; i<beforeUsers.size(); i++){
                if((beforeUsers.get(i).getUsercardcode()).equals(user.getUsercardcode())){
                    user=null;
                }
        }
        if (user!=null){
            Long userId = zhaoUserMapper.getNewUserId();
            user.setUserid(userId);
            user.setCompanyid(companyId);
            result = zhaoUserMapper.insertUser(user);
        }
        return result;
    }

    //删除用户
    @Override
    public boolean deleteUser(Long userId) {
        Integer result=0;
        result = zhaoUserMapper.deleteUser(userId);
        return result>0;
    }

    //修改用户
    @Override
    public boolean updateUser(User user) {
        Integer result=0;
        result = zhaoUserMapper.updateUser(user);
        return result>0;
    }
}
