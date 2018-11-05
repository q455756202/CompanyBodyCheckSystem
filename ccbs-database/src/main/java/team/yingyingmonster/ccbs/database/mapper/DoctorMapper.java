package team.yingyingmonster.ccbs.database.mapper;

import org.springframework.stereotype.Repository;
import team.yingyingmonster.ccbs.database.bean.Doctor;

import java.util.List;

@Repository
public interface DoctorMapper {
    Doctor selectByPrimaryKey(Long doctorid);
    int deleteByPrimaryKey(Long doctorid);
    int insert(Doctor doctor);
    int insertSelective(Doctor doctors);
    int updateByPrimaryKeySelective(Doctor doctors);
    int updateByPrimaryKey(Doctor doctor);
}
