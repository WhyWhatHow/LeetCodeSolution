package other;

import java.io.*;
import java.util.HashMap;
import java.util.Random;

/**
 * @program: LeetCodeSolution
 * @description: 新概念英语 课文测试
 * @author: WhyWhatHow
 * @create: 2021-08-11 09:01
 **/
public class NewConceptEnglish {
    HashMap<Integer, Boolean> learnedLessons = null;
    int lessons;
    String fileName = "learningEnglish.tmp";

    public static void main(String[] args) throws Exception {
        NewConceptEnglish demo = new NewConceptEnglish();
        demo.init();
        int lesson = demo.testRead(35);
        System.out.println(" Today you should review lesson "+lesson );
        demo.save();
//        run();
    }

    void init() throws Exception {
        File savedFile = new File(fileName);
        if (savedFile.exists()) {// 如果文件存在就继续读,如果第一次使用就不读文件, 继续做
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            learnedLessons = (HashMap) ois.readObject();
            fis.close();
            ois.close();
        }else{
            learnedLessons =new HashMap<>();
        }

    }

    int testRead(int aleadyLearn) {
        Random random = new Random();
        int x = -1;
        while (true) {
            x = random.nextInt(aleadyLearn);
            if ((x & 1) == 0 || learnedLessons.containsKey(x)) {
                continue; // 偶数单元记录
            }
            learnedLessons.put(x, true);
            break;
        }
        return x;
    }

    void save() {
        if (learnedLessons == null || learnedLessons.isEmpty()) {
            throw new RuntimeException("New Concept English save operation failed , reason:  learnedLessons ==null || learnedLessons is Empty");
        }
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(learnedLessons);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                fos.close();
                oos.close();
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }


//        ObjectOutputStream outputStream= new ObjectOutputStream(new );
    }
}
