package parents;

/**
 * @ClassName VersionControl
 * @Author 36d
 * @Date 2021/6/13 12:00
 * @Description 错误版本抽象
 **/
public class VersionControl {

    private final boolean[] versions;

    /**
     * 构造方法
     * @param n 版本数量
     * @param wrongIndex 第一个错误版本的索引
     */
    public VersionControl(int n, int wrongIndex) {
        versions = new boolean[n+1];
        for (int i = wrongIndex; i <= n; ++i) {
            versions[i] = true;
        }
    }

    /**
     * 判断第index个版本是否错误
     * @param index
     * @return
     */
    public boolean isBadVersion(int index) {
        return versions[index];
    }

}
