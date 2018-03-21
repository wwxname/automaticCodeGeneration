package ${Project.programServiceImpl};

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.td.framework.sql.AdvSqlDaoImpl;
import ${Project.programRepository}.${ClazzSet.className}Repository;
import ${Project.programService}.${ClazzSet.className}Service;
${ClazzSet.javaImport}

@Service
@Transactional
public class ${ClazzSet.className}ServiceImpl extends AdvSqlDaoImpl<${ClazzSet.className}Repository,${ClazzSet.className}, ${ClazzSet.code}> implements ${ClazzSet.className}Service{

}