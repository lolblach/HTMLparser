import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements

class Parser {
    private val url = "http://timetable.sutr.ru/groups"
    private val result: MutableList<String> = mutableListOf()

    fun main(){
        println(parseListGroups())
    }

    fun parseListGroups(){
        val document : Document = Jsoup.connect(url).get()
        val element : Elements = document.select("ul[group-list tile shadow]")
        println(document)

        for (i in 0 until element.size){
            val groupId : String = BASE_URL +
                element.select("li[group]")
                .select("a")
                .eq(i)
                .attr("href")
                .toString()

            val groupName : String = element.select("li[group]")
                .select("a")
                .eq(i)
                .toString()

            println(groupId)
        }
    }

    fun parseTimetable(groupId : String){

    }

    companion object{
        private const val BASE_URL = "http://timetable.sutr.ru/"
    }
}