package geek.spring.all.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author [wangjiahui]
 * @ClassName: FooSubServiceImpl
 * @CreateDate: [2019-09-19 20:49]
 * @Description: [TODO]
 * @version: [V1.0]
 */
@Component
public class FooSubServiceImpl implements FooSubService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertRecord(){
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public void insertThenRollback() throws RollBackException {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
        throw new RollBackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollBackException {
        insertThenRollback();
    }
}
