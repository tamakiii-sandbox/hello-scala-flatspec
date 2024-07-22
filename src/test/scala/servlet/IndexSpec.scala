import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import org.scalatest.BeforeAndAfterEach
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.io.{PrintWriter, StringWriter}
import scala.compiletime.uninitialized
import com.example.main.servlet.Index
import com.example.main.{HttpServletRequestParser, Request}

class IndexSpec
    extends AnyFlatSpec
    with Matchers
    with MockitoSugar
    with BeforeAndAfterEach {

  var request: HttpServletRequest = uninitialized
  var response: HttpServletResponse = uninitialized
  var writer: StringWriter = uninitialized
  var servlet: Index = uninitialized
  var mockParser: HttpServletRequestParser = uninitialized

  override def beforeEach() = {
    request = mock[HttpServletRequest]
    response = mock[HttpServletResponse]
    writer = new StringWriter
    mockParser = mock[HttpServletRequestParser]
    servlet = new Index(mockParser)
    when(response.getWriter).thenReturn(new PrintWriter(writer))
  }

  "doGet" should "return error when id is missing" in {
    when(mockParser.parse(request)).thenReturn(Left(new Exception("ID is empty")))

    servlet.doGet(request, response)

    verify(response).setContentType("text/plain")
    writer.toString should include("Error: ID is empty")
  }

  it should "return Hello with id when id is present" in {
    when(mockParser.parse(request)).thenReturn(Right(Request("12345")))

    servlet.doGet(request, response)

    verify(response).setContentType("text/plain")
    writer.toString should include("Hello, 12345!")
  }
}
