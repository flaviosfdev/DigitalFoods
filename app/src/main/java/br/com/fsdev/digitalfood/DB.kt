package br.com.fsdev.digitalfood

import br.com.fsdev.digitalfood.models.Banner
import br.com.fsdev.digitalfood.models.Categoria
import br.com.fsdev.digitalfood.models.Plate
import br.com.fsdev.digitalfood.models.Restaurant

class DB {

    companion object {

        fun getRestaurants() = List(10){
            Restaurant(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnG9NgjPo1pSUM0_Cc1gNIiGWY-oy-h7U2i9i1AlSR_6VGayme8vrv1VCMZbqsq54T6CQ&usqp=CAU",
                "Outback Morumbi Shopping",
                "Avenida Roque Petroni Júnior, 1089 - Jardim das Acácias - CEP: 04707-900 - São Paulo – SP",
                "Fecha às 22h"
            )
        }

        fun getPlates() = List(10){
            Plate(
                "https://www.delonghi.com/Global/recipes/multifry/97.jpg",
                "Pizza",
                "Vários sabores de pizza"
            )
        }

        fun getBanners(): List<Banner> {
            return listOf(
                Banner("https://i.pinimg.com/originals/cf/c7/6e/cfc76e3b3d518173e82e0f8bd9d3e152.jpg"),
                Banner("https://d1csarkz8obe9u.cloudfront.net/posterpreviews/pizza-banner-design-template-5623a47ee70d2ca4f3a4eca9c19a8039_screen.jpg"),
                Banner("https://www.designi.com.br/images/preview/10024884.jpg")
            )
        }


        fun getCategorias(): List<Categoria> {
            return listOf(
                Categoria("Açaí", "https://img.vixdata.io/pd/jpg-large/pt/sites/default/files/r/receita-de-mousse-de-acai-1017-1400x800.jpg"),

                Categoria("Hamburger", "https://media-cdn.tripadvisor.com/media/photo-s/1a/8e/31/df/capitao-barba-negra-hamburguer.jpg"),

                Categoria("Pizza", "https://mluyvla67oss.i.optimole.com/MC1DnVk-T1EWAKy5/w:1080/h:1080/q:auto/https://academiagourmet.net.br/wp-content/uploads/2019/09/Pizza-academia-gourmet-sua-academia-de-cursos-e-treinamentos-de-culinaria-e-gastronomia-novo-curso.png"),

                Categoria("Sorvete", "https://blog.gsuplementos.com.br/wp-content/uploads/2020/11/iStock-1264447431.jpg"),

                Categoria("Espetinho", "https://www.curtamais.com.br/uploads/conteudos/06a4927dcc2c51dc001827aba2d426d9.jpg"),
            )
        }

    }

}