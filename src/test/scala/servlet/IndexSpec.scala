import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.mockito.MockitoSugar
import org.mockito.Mockito._
import org.mockito.ArgumentMatchers._
import org.mockito.ArgumentCaptor

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import java.io.{PrintWriter, StringWriter}

import com.example.main.servlet.Index

class IndexSpec extends AnyFlatSpec with Matchers with MockitoSugar {
  "doGet" should "set content type to text/plain" in {
    val request = mock[HttpServletRequest]
    val response = mock[HttpServletResponse]
    val writer = new StringWriter
    when(response.getWriter).thenReturn(new PrintWriter(writer))

    val servlet = new Index
    servlet.doGet(request, response)

    verify(response).setContentType("text/plain")
  }

  it should "write 'Hello, World!' to the response" in {
    val request = mock[HttpServletRequest]
    val response = mock[HttpServletResponse]
    val writer = new StringWriter
    when(response.getWriter).thenReturn(new PrintWriter(writer))

    val servlet = new Index
    servlet.doGet(request, response)

    writer.toString should include ("Hello, World!")
  }
}
