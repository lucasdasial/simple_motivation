package com.dasial.motivation.data

import com.dasial.motivation.infra.Constants
import com.dasial.motivation.models.Phrase
import kotlin.random.Random


class Mock {

    private val all = Constants.FILTER.ALL
    private val sunny = Constants.FILTER.SUNNY
    private val happy = Constants.FILTER.HAPPY

    private val listPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny),
        Phrase("Você perde todas as chances que você não aproveita.", sunny),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny),
        Phrase("Se você acredita, faz toda a diferença.", sunny),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny)
    )


    fun getPhrase(id: Int): String {


        val filtered = listPhrase.filter {
            it.categoryId == id || id == all
        }
        val index = Random.nextInt(filtered.size)

        return filtered[index].description
    }

}