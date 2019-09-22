package geek.spring.all.declarativetransactiondemo;

/**
 * @author [wangjiahui]
 * @ClassName: FooService
 * @CreateDate: [2019-09-19 20:38]
 * @Description: [TODO]
 * @version: [V1.0]
 */
public interface FooService {
    void insertRecord();
    void insertThenRollback() throws RollBackException;
    void invokeInsertThenRollback() throws RollBackException;
}
