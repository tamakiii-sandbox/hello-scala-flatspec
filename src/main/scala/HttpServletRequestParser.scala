package com.example.main

import javax.servlet.http.HttpServletRequest

trait HttpServletRequestParser {
  def parse(req: HttpServletRequest): Either[Exception, Request]
}

object DefaultHttpServletRequestParser extends HttpServletRequestParser {
  def parse(req: HttpServletRequest): Either[Exception, Request] = {
    val id = req.getParameter("id")

    id match {
      case null => Left(new Exception("ID is empty"))
      case _    => Right(Request(id))
    }
  }
}
