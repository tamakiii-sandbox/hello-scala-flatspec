package com.example.main

import javax.servlet.http.HttpServletRequest
import com.example.main.Request

object HttpServletRequestParser {
  def parse(req: HttpServletRequest): Either[Exception, Request] = {
    val id = req.getParameter("id")

    id match {
      case null => Left(new Exception("ID is empty"))
      case _    => Right(Request(req))
    }
  }
}
