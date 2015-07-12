package sandbox;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

import am.ik.ltsv4j.LTSV;

public class LTSVTest {

	private static final Logger LOGGER = Logger.getLogger(LTSVTest.class);

	@Test
	public void testName() throws Exception {
		{
			Map<String, String> line = LTSV.parser().parseLine("hoge:foo\tbar:baz\n");// => {"hoge" : "foo", "bar" : "baz"}
			String line2 = LTSV.formatter().formatLine(line);// => // "hoge:foo\tbar:baz"
			LOGGER.info(line2);
		}

		{
			Map<String, String> line = LTSV.parser().ignores("hoge").parseLine("hoge:foo\tbar:baz\n");// => {"bar" : "baz"}
		}
		{
			Map<String, String> line = LTSV.parser().wants("hoge").parseLine("hoge:foo\tbar:baz\n");// => {"hoge" : "foo"}
		}

		{
			//			List<Map<String, String>> lines = LTSV.parser().parseLines(
			//					"test.ltsv");
			//			LTSV.formatter().formatLines(lines, "foo.ltsv");
		}
	}
}
