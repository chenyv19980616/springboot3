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
public class FormatLPOrderCode {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        // 相对路径
        String inputFile = "demo/shuru.txt"; // 输入文件名
        String outputFile = "demo/formatted_tracking_numbers.txt"; // 输出文件名

        Path inputPath = Paths.get(inputFile);
        Path outputPath = Paths.get(outputFile);

        try (BufferedReader reader = Files.newBufferedReader(inputPath);
             BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardOpenOption.CREATE)) {

            String lpOrderCode;
            int a = 0;
            while ((lpOrderCode = reader.readLine()) != null) {
                if (a++ != 0) {
                    writer.write(",\n");
                }
                // 创建格式化的跟踪号码
                String formatted = "\"" + lpOrderCode + "\"";
                // 写入到输出文件
                writer.write(formatted);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}