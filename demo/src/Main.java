import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 读取txt文件
 */
public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        // 相对路径
        String inputFile = "demo/shuru.txt"; // 输入文件名
        String outputFile = "demo/formatted_tracking_numbers.txt"; // 输出文件名

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE)) {

            String trackingNumber;
            while ((trackingNumber = reader.readLine()) != null) {
                // 创建格式化的跟踪号码
                String formatted = "\"" + trackingNumber + "\",\n";
                // 写入到输出文件
                writer.write(formatted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}