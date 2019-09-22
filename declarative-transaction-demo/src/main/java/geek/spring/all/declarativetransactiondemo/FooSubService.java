package geek.spring.all.declarativetransactiondemo;

/**
 * @author [wangjiahui]
 * @ClassName: FooSubService
 * @CreateDate: [2019-09-19 20:49]
 * @Description: [TODO]
 * @version: [V1.0]
 */
public interface FooSubService {
    void insertRecord();
    void insertThenRollback() throws RollBackException;
    void invokeInsertThenRollback() throws RollBackException;
}
