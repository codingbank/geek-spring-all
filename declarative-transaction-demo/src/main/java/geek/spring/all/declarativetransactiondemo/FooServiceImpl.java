package geek.spring.all.declarativetransactiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author [wangjiahui]
 * @ClassName: FooServiceImpl
 * @CreateDate: [2019-09-19 20:39]
 * @Description: [TODO]
 * @version: [V1.0]
 */
@Component
public class FooServiceImpl implements FooService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FooSubService fooSubService;

    @Override
    @Transactional
    public void insertRecord() {
        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('AAA')");
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public void insertThenRollback() throws RollBackException {
//        jdbcTemplate.execute("INSERT INTO FOO (BAR) VALUES ('BBB')");
//        fooSubService.insertRecord();
        fooSubService.invokeInsertThenRollback();
        throw new RollBackException();
    }

    @Override
    @Transactional(rollbackFor = RollBackException.class)
    public void invokeInsertThenRollback() throws RollBackException {
        insertThenRollback();
    }
}
