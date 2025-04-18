//import org.scalajs.dom
import org.scalajs.dom.{Element, HTMLCollection, HTMLDivElement, MouseEvent, NodeList, document}

import scala.scalajs.js.annotation.JSExportTopLevel
import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import com.raquo.laminar.{inserters, keys, lifecycle, modifiers, nodes}
import com.raquo.laminar.defs.complex.{ComplexHtmlKeys, ComplexSvgKeys}
import com.raquo.laminar.nodes.ReactiveElement
import org.scalajs.dom
import com.raquo.laminar.defs.styles
import com.raquo.laminar.api.features.unitArrows
import com.raquo.laminar.tags.HtmlTag


object Util {
  def intToPixel(k: Int): String = s"${k.toString}px"
}

object SideNav {
  def apply(): HtmlElement = {
    sideNav()
  }

  val sideNavBtnWidth = "30px"

  val sideNavWidth: Var[String] = Var("0px")
  val sideNavHeight = "400px"

  def hide(): Unit =
    sideNavWidth.update(_ => "0px")

  def show(): Unit =
    sideNavWidth.update(_ => "250px")

  def sideMenu(): HtmlElement = ul(
    p(a( href:="javascript:void(0);", "speakers")),
    //p(a( href:="javascript:void(0);", "speeches")),
  )

  def sideNavBtn(): HtmlElement = button(typ := "button", "\u2715",
    cls := "sideNavBtn",
    float:="left top",
    // transition := "0.5s",
    overflow := "hidden",
    // visibility <-- sideNavBtnVis.signal,
    zIndex := "10",
    margin := "5px",
    // top := "0", left := "0",
    width := sideNavBtnWidth,
    backgroundColor := "lightGray",
    borderStyle := "solid",
    borderWidth := "1px",
    borderColor := "darkGray",
    onClick --> { _ =>
      hide()
    }
  )

  def sideNav(): HtmlElement = div(cls := "mySidenav",
    width <-- sideNavWidth.signal,
    height := sideNavHeight,
    // float:="top left",
    top := "0px", left := "0px",
    position := "absolute",
    //margin:="1px",
    backgroundColor := "lightGray",
    zIndex := "10",
    transition := "0.5s",
    overflow := "hidden",
    cls("mySidenav"),
    //borderStyle := "solid",
    borderWidth := "0px",
    // borderColor := "green",
    sideNavBtn(),
    sideMenu(),
  )


}

object Header {

  def apply(): HtmlElement = hdr()

  val menuBtnWidth = 30
  val menuBtnHeight = 30
  val btnBkgColor: Var[String] = Var("transparent")


  def stripe(clr: String): HtmlElement = div(
    width := Util.intToPixel(menuBtnWidth -8),
    height := "2px",
    backgroundColor := clr,
    margin := "4px",
  )

  def hdrBtn(): HtmlElement = div( cls:="hdrbtn",
    width := Util.intToPixel(menuBtnWidth),
    height := Util.intToPixel(menuBtnHeight),
    margin:="3px",
    float := "top",
    overflow := "hidden",
    backgroundColor <-- btnBkgColor.signal, //"lightGray",
    borderStyle := "solid",
    borderWidth := "0px",
    borderColor := "red",
    zIndex := "1",
    stripe("blue"),
    stripe("blue"),
    stripe("blue"),
    onMouseEnter --> { _ =>
      btnBkgColor.update(_ => "lightBlue")
    },
    onMouseLeave --> { _ =>
      btnBkgColor.update(_ => "transparent")
    },
    onClick --> { _ =>
      SideNav.show()
    }
  )

  def hdr(): HtmlElement = div(
    width := "100%", height := "50px",
    top := "0", left := "0",
    float := "left",
    //position := "absolute",
    overflow := "visible",
    //margin:="1px",
    backgroundColor := "azure",
    borderStyle := "solid",
    borderWidth := "1px",
    borderColor := "lightBlue",
    zIndex := "1",
    hdrBtn(),
    onClick --> { event =>
      if (250 < event.clientX) SideNav.hide()
    }
  )
}

@main
def main(): Unit = {
  renderOnDomContentLoaded( document.body, Header())
  renderOnDomContentLoaded( document.body, SideNav())
}