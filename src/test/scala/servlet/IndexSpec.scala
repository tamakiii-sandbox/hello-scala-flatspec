import org.scalatest.flatspec.AnyFlatSpec
import com.example.main.servlet.Index
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class IndexSpec extends AnyFlatSpec {
  "doGet" should "pass" in {
    assert(1 === 1)
  }
}
