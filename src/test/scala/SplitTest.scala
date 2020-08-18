/**
 *
 * @author wangziyu1
 * @date 2020-10-29 11:41
 *
 */
object SplitTest {
  def main(args: Array[String]): Unit = {

    val aa = "100_1018:0,100_3011:20300"
    val value = aa.split(",")(1).split(":")(1)
    println(value)

    val bb = "172.20.49.108_2020-10-30 15:03:25_{\"body\":\"{\\\"apmId\\\":123,\\\"qmtd\\\":1,\\\"qtype\\\":1,\\\"purl\\\":\\\"file:///Users/yiche1/projj/gitlab.bitautotech.com/wubq/monitor-sdk/examples/ajax/axios.html\\\",\\\"dswh\\\":\\\"1440*900\\\",\\\"ddb\\\":\\\"Chrome\\\",\\\"ddbv\\\":\\\"86.0.4240.111\\\",\\\"dvid\\\":\\\"0.0.1\\\",\\\"dov\\\":\\\"1.0.0\\\",\\\"rdot\\\":\\\"2020-10-30 15:03:15\\\",\\\"ltype\\\":8,\\\"cid\\\":\\\"\\\",\\\"itime\\\":\\\"\\\",\\\"url\\\":\\\"http://192.168.87.167:3001/user/list\\\",\\\"ercd\\\":\\\"::200\\\",\\\"dur\\\":45,\\\"nt\\\":2,\\\"gudslf\\\":\\\"wh4l90qmcnhyrdirxzeeeut0i\\\",\\\"gudpar\\\":\\\"\\\",\\\"seq\\\":0,\\\"refer\\\":\\\"\\\",\\\"reqid\\\":0,\\\"ip\\\":\\\"223.71.57.118\\\",\\\"osl\\\":\\\"Mac OS\\\",\\\"osvl\\\":\\\"10.15.6\\\",\\\"uidl\\\":\\\"wh4l90qmcnhyrdirxzeeeut0i\\\",\\\"inbyte\\\":14,\\\"outbyte\\\":57,\\\"lgin\\\":\\\"{\\\\\\\"id\\\\\\\":\\\\\\\"10000\\\\\\\"}\\\",\\\"lgout\\\":\\\"{\\\\\\\"success\\\\\\\":true,\\\\\\\"status\\\\\\\":1,\\\\\\\"message\\\\\\\":\\\\\\\"success\\\\\\\",\\\\\\\"data\\\\\\\":{}}\\\",\\\"cya\\\":\\\"北京市\\\"}"
    println(bb.contains("\\\"ltype\\\":8"))

  }

}
