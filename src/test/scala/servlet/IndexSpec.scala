import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import javax.servlet.http.{HttpServletRequest, HttpServletResponse}
import java.io.{PrintWriter, StringWriter}
import com.example.main.servlet.Index

class IndexSpec extends AnyFlatSpec with Matchers with MockitoSugar {

  "doGet" should "return error when id is missing" in {
    val request = mock[HttpServletRequest]
    val response = mock[HttpServletResponse]
    val writer = new StringWriter
    when(response.getWriter).thenReturn(new PrintWriter(writer))
    when(request.getParameter("id")).thenReturn(null)

    val servlet = new Index
    servlet.doGet(request, response)

    verify(response).setContentType("text/plain")
    writer.toString should include("Error: ID is empty")
  }

  it should "return Hello with id when id is present" in {
    val request = mock[HttpServletRequest]
    val response = mock[HttpServletResponse]
    val writer = new StringWriter
    when(response.getWriter).thenReturn(new PrintWriter(writer))
    when(request.getParameter("id")).thenReturn("12345")

    val servlet = new Index
    servlet.doGet(request, response)

    verify(response).setContentType("text/plain")
    writer.toString should include("Hello, 12345!")
  }
}
