// package hello
 
// import scalafx.application.JFXApp
// import scalafx.application.JFXApp.PrimaryStage
// import scalafx.geometry.Insets
// import scalafx.scene.Scene
// import scalafx.scene.control.Label
// import scalafx.scene.layout.BorderPane
 
// object HelloSBT extends JFXApp {
//   stage = new PrimaryStage {
//     scene = new Scene {
//       root = new BorderPane {
//         padding = Insets(25)
//         center = new Label("Hello SBT")
//       }
//     }
//   }
// }
package hello

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.geometry.Insets
import scalafx.scene.Scene
import scalafx.scene.effect.DropShadow
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{Stops, LinearGradient}
import scalafx.scene.text.Text

object ScalaFXHelloWorld extends JFXApp {

  stage = new PrimaryStage {
    title = "ScalaFX Hello World"
    width = 800
	height = 600
    scene = new Scene {
      fill = BLACK
      content = new HBox {
        padding = Insets(20)
        content = Seq(
          new Text {
            text = "Hello "
            style = "-fx-font-size: 48pt"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(PALEGREEN, SEAGREEN))
          },
          new Text {
            text = "World!!!"
            style = "-fx-font-size: 48pt"
            fill = new LinearGradient(
              endX = 0,
              stops = Stops(CYAN, DODGERBLUE)
            )
            effect = new DropShadow {
              color = DODGERBLUE
              radius = 25
              spread = 0.25
            }
          }
        )
      }
    }
  }
}