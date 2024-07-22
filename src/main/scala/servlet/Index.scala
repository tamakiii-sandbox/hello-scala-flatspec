package com.example.main.servlet

import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse
import com.example.main.HttpServletRequestParser

class Index extends HttpServlet {
  override def doGet(
      req: HttpServletRequest,
      resp: HttpServletResponse
  ): Unit = {
    val request = HttpServletRequestParser.parse(req)
    resp.setContentType("text/plain")
    resp.getWriter.println("Hello, World!")
  }
}
