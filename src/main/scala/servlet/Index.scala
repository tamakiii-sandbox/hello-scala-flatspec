package com.example.main.servlet

import javax.servlet.http.{HttpServlet, HttpServletRequest, HttpServletResponse}
import com.example.main.HttpServletRequestParser

class Index(parser: HttpServletRequestParser) extends HttpServlet {
  override def doGet(
      req: HttpServletRequest,
      resp: HttpServletResponse
  ): Unit = {
    val request = parser.parse(req)
    resp.setContentType("text/plain")
    request match {
      case Left(exception) =>
        resp.getWriter.println(s"Error: ${exception.getMessage}")
      case Right(req) => resp.getWriter.println(s"Hello, ${req.id}!")
    }
  }
}
