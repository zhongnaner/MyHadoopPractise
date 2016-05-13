import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MaxTemperatureMapper extends Mapper<LongWritable, Text, Text, IntWritable> {
	private static final int MISSING = 9999;
	    @Override
		public void map(LongWritable key, Text value, Context context)
		throws IOException, InterruptedException {
		String line = value.toString();
		String year = line.substring(13, 17);
		int airTemperature;
		airTemperature = Integer.parseInt(line.substring(88, 92));
		String quality = line.substring(19, 23);
		context.write(new Text(year), new IntWritable(airTemperature));
	}
}
