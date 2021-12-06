package br.com.fsdev.digitalfood

import br.com.fsdev.digitalfood.models.Banner
import br.com.fsdev.digitalfood.models.Categoria
import br.com.fsdev.digitalfood.models.Plate
import br.com.fsdev.digitalfood.models.Restaurant

class DB {

    companion object {

        fun getRestaurants(): List<Restaurant> = listOf(
            Restaurant(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnG9NgjPo1pSUM0_Cc1gNIiGWY-oy-h7U2i9i1AlSR_6VGayme8vrv1VCMZbqsq54T6CQ&usqp=CAU",
                "Outback Morumbi Shopping",
                "Avenida Roque Petroni Júnior, 1089 - Jardim das Acácias - São Paulo – SP",
                "Fecha às 22h"
            ),
            Restaurant(
                "https://static-images.ifood.com.br/image/upload/t_high/logosgde/c326b3e6-5323-4347-beb5-2c7524a96e70/202010271416_cDXW_i.jpg",
                "Sorveteria Frosty",
                "Avenida Rio Branco, 1089 - Centro - Mossoró – RN",
                "Fecha às 23h"
            ),
            Restaurant(
                "https://img5.findglocal.com/035/630/1330614560356308.jpg",
                "Lanchonete HotDog O Sebosão",
                "Avenida Presidente Dultra, S/N - Centro - Mossoró – RN",
                "Aberto das 18h às 04h"
            ),
            Restaurant(
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTnG9NgjPo1pSUM0_Cc1gNIiGWY-oy-h7U2i9i1AlSR_6VGayme8vrv1VCMZbqsq54T6CQ&usqp=CAU",
                "Outback Morumbi Shopping",
                "Avenida Roque Petroni Júnior, 1089 - Jardim das Acácias - São Paulo – SP",
                "Fecha às 22h"
            ),
            Restaurant(
                "https://static-images.ifood.com.br/image/upload/t_high/logosgde/c326b3e6-5323-4347-beb5-2c7524a96e70/202010271416_cDXW_i.jpg",
                "Sorveteria Frosty",
                "Avenida Rio Branco, 1089 - Centro - Mossoró – RN",
                "Fecha às 23h"
            ),
            Restaurant(
                "https://img5.findglocal.com/035/630/1330614560356308.jpg",
                "Lanchonete HotDog O Sebosão",
                "Avenida Presidente Dultra, S/N - Centro - Mossoró – RN",
                "Aberto das 18h às 04h"
            ),
        )

        fun getMenu(): List<Plate> = listOf(
            Plate(
                "https://img.vixdata.io/pd/jpg-large/pt/sites/default/files/r/receita-de-mousse-de-acai-1017-1400x800.jpg",
                "Açaí",
                "O melhor açaí da cidade"
            ),
            Plate(
                "https://media-cdn.tripadvisor.com/media/photo-s/1a/8e/31/df/capitao-barba-negra-hamburguer.jpg",
                "Hamburger",
                "O mais suculento da cidade"
            ),
            Plate(
                "https://www.delonghi.com/Global/recipes/multifry/97.jpg",
                "Pizza",
                "Vários sabores de pizza"
            ),
            Plate(
                "https://blog.gsuplementos.com.br/wp-content/uploads/2020/11/iStock-1264447431.jpg",
                "Sorvete",
                "Vários sabores de pizza"
            ),
            Plate(
                "https://www.curtamais.com.br/uploads/conteudos/06a4927dcc2c51dc001827aba2d426d9.jpg",
                "Espetinho",
                "Vários sabores"
            ),
        )

    }

}