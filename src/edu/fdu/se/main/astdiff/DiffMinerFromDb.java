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
public class DiffMinerFromDb extends BaseDiffMiner {

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
        int candidateIndex = 0;
        String rootOutPath = ProjectProperties.getInstance().getValue(PropertyKeys.DIFF_MINER_GUMTREE_OUTPUT_DIR);
        System.out.println(filePathList.size());
        int size = filePathList.size();
        for (int i = candidateIndex; i < candidateIndex + 10; i++) {
            String subPath = filePathList.get(i);
            if (i != 0) {
                continue;
            }
            System.out.println(i + ": " + subPath);
            String subPath2 = subPath.replace("\\", "/");
            String outputDirName = subPath.replace("\\", "_").substring(1);
            String fileFullPathPrev = fileRootPathPrev + subPath2;
            String fileFullPathCurr = fileRootPathCurr + subPath2;
//            try {

            doo(fileFullPathPrev, fileFullPathCurr, rootOutPath + "/" + outputDirName);
//            }catch(Exception e){
//                e.printStackTrace();
//            }
            break;
        }
    }


    public static void main(String[] args) {
        DiffMinerFromDb i = new DiffMinerFromDb();
        i.runBatch();
    }

}
