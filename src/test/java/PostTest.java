import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author wangziyu1
 * @date 2020-12-22 15:45
 * 模拟post请求,主要目的是调用precheck微服务的redis批量删除的接口
 * 根据title文本文件,每一行为一个title,删除
 * 参数通过args传递
 * args[0] : 需要请求的地址
 * args[1] : 需要删除文件的绝对路径,文件默认一行一个title
 */
public class PostTest {
    public static void main(String[] args) {
        if (args.length == 2) {
            if (args[0].equals("") || 0 == args[0].length()) {
                System.err.println("此次请求地址为空,请检查参数传递是否有误!");
                return;
            } else if (!args[0].startsWith("http")) {
                System.err.println("此次请求地址格式有误,不是http或者https开头.");
                return;
            } else {
                System.out.println("此次请求地址为:" + args[0]);
            }

            if (args[1].equals("") || 0 == args[0].length()) {
                System.err.println("此次上传的文件路径为空,请检查参数传递是否有误!");
                return;
            } else if (!args[1].endsWith(".txt")) {
                System.err.println("此次请求地址格式有误,不是txt结尾文件,目前只支持txt文件.");
                return;
            } else {
                System.out.println("此次上传的文件路径为:" + args[0]);
            }
        } else {
            System.err.println("此次请求参数不够,请检查参数传递是否有误!");
            return;
        }
        long start_time = System.currentTimeMillis();
        String result = uploadFile(args[0],
                "file",
                args[1]);
        long end_time = System.currentTimeMillis();
        System.out.println("此次总耗时:" + (end_time - start_time) + "毫秒");
        System.out.println("此次请求结果为:" + result);
    }

    /**
     * 模拟文件post上传
     *
     * @param urlStr（接口地址）
     * @param formName（接口file接收名）
     * @param fileName（需要上传文件的本地路径）
     * @return文件上传到接口返回的结果
     */
    public static String uploadFile(String urlStr, String formName, String fileName) {
        String baseResult = null;
        try {
            final String newLine = "\r\n";
            final String boundaryPrefix = "--";
            String BOUNDARY = "========7d4a6d158c9";// 模拟数据分隔线
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");// 设置为POST请求
            conn.setDoOutput(true);
            conn.setDoInput(true);

            conn.setRequestProperty("connection", "Keep-Alive");// 设置请求头参数
            conn.setRequestProperty("Charsert", "UTF-8");
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);
            OutputStream out = conn.getOutputStream();

            File file = new File(fileName);
            StringBuilder sb = new StringBuilder();
            sb.append(boundaryPrefix);
            sb.append(BOUNDARY);
            sb.append(newLine);
            sb.append("Content-Disposition: form-data;name=\"" + formName + "\";filename=\"" + fileName + "\"" + newLine);
            sb.append("Content-Type:application/octet-stream");
            sb.append(newLine);
            sb.append(newLine);

            out.write(sb.toString().getBytes());// 将参数头的数据写入到输出流中

            DataInputStream in = new DataInputStream(new FileInputStream(file));// 数据输入流,用于读取文件数据
            byte[] bufferOut = new byte[1024];
            int bytes = 0;

            while ((bytes = in.read(bufferOut)) != -1) {// 每次读1KB数据,并且将文件数据写入到输出流中
                out.write(bufferOut, 0, bytes);
            }

            out.write(newLine.getBytes());
            in.close();

            byte[] end_data = (newLine + boundaryPrefix + BOUNDARY
                    + boundaryPrefix + newLine).getBytes();

            out.write(end_data);
            out.flush();
            out.close();


            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    conn.getInputStream()));
            String line = null;
            StringBuffer strs = new StringBuffer("");
            while ((line = reader.readLine()) != null) {
                strs.append(line);
            }
            baseResult = strs.toString();
        } catch (Exception e) {
            baseResult = e.getMessage();
        }
        return baseResult;
    }
}
