package edu.fdu.se.main.astdiff;



import edu.fdu.se.bean.AndroidSDKJavaFile;
import edu.fdu.se.config.ProjectProperties;
import edu.fdu.se.config.PropertyKeys;
import edu.fdu.se.dao.AndroidSDKJavaFileDAO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * given two files, generate edit script.
 *
 * @author huangkaifeng
 */
public class DiffMiner extends BaseDiffMiner {

    public List<String> readCompareList(int version, String prevPath, String currPath) {
        prevList = new ArrayList<>();
        currList = new ArrayList<>();
        List<String> fileSubPathList = new ArrayList<>();
        currList = AndroidSDKJavaFileDAO.selectAllTagSnapshotFileBySDKVersion(version);
        Map<String, Integer> fileNameMap = new HashMap<>();
        for (AndroidSDKJavaFile item : currList) {
            fileNameMap.put(item.getSubSubCategoryPath(), 1);
        }
        prevList = AndroidSDKJavaFileDAO.selectAllTagSnapshotFileBySDKVersion(version - 1);
        for (AndroidSDKJavaFile item : prevList) {
            String filePath = item.getSubSubCategoryPath();
            if (fileNameMap.containsKey(filePath)) {
                File filePrevFull = new File(prevPath + filePath.replace("\\", "/"));
                File fileCurrFull = new File(currPath + filePath.replace("\\", "/"));
                if (filePrevFull.length() != fileCurrFull.length()) {
                    fileSubPathList.add(filePath);
                }
            }
        }
        return fileSubPathList;

    }

    private List<AndroidSDKJavaFile> prevList;
    private List<AndroidSDKJavaFile> currList;


    public void runBatch() {
        int version = 26;
        String fileRootPathPrev
                = ProjectProperties.getInstance().getValue(PropertyKeys.DIFF_MINER_NEW_SDK_DIR) + "/android-" + String.valueOf(version - 1);
        String fileRootPathCurr
                = ProjectProperties.getInstance().getValue(PropertyKeys.DIFF_MINER_NEW_SDK_DIR) + "/android-" + String.valueOf(version);
        List<String> filePathList = readCompareList(version, fileRootPathPrev, fileRootPathCurr);
        int cnt = 0;
        int candidateIndex = 26;
        System.out.println(filePathList.size());
        for(int i = 0;i<filePathList.size();i++){
            String subPath = filePathList.get(i);
            if(i!=candidateIndex){
                continue;
            }
//            if(!(subPath.equals("\\android\\accessibilityservice\\AccessibilityServiceInfo.java"))){
//                continue;
//            }
            System.out.println(i+ ": "+subPath);
            String subPath2 = subPath.replace("\\", "/");
            String outputDirName = subPath.replace("\\", "_").substring(1);
            String fileFullPathPrev = fileRootPathPrev + subPath2;
            String fileFullPathCurr = fileRootPathCurr + subPath2;
            doo(fileFullPathPrev, fileFullPathCurr, outputDirName);
            break;
        }
    }
    public static void main(String []args) {
        DiffMiner i = new DiffMiner();
		i.runBatch();
    }

    //todo block 为move的情况

    //todo move 复杂操作处理  需要考虑两个树之间的行数mapping

    //todo link各种


    //4-2 讨论
    // 1. Type Binding问题
    // 3. Insert condition +  Move
    // 4. Insert condition body + Move
    // 5. Preprocessing toString问题
    // 6. Insert Stmt

//  Key -> Value
//  BodyDeclaration -> List<ChangeEntity> 发生在这个BodyDeclaration里面的change entity
//  BodyDeclaration [rangeA,rangeB]  -> List<ChangeEntity>

    // change entity 为member,找往上的class declaration 节点 的bodyDeclaration
    // change entity 为statement,往上找method declaration 节点 bodyDeclaration
    // change entity 为class,往上找

    // 预处理的change entity : add member / remove member 都可以放入以src 的BodyDeclaration 不考虑行号
    // gumtree 拓展识别的change entity add member / remove member  add stmt remove stmt
    // add节点UpDown 往上找到mapping的节点,src的range 其他则
}
