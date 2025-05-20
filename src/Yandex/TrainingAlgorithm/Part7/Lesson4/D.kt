package Yandex.TrainingAlgorithm.Part7.Lesson4
//
//import java.io.BufferedReader
//import java.io.BufferedWriter
//import java.io.InputStreamReader
//import java.io.OutputStreamWriter
//
//fun main(args: Array<String>) {
//    val reader = BufferedReader(InputStreamReader(System.`in`))
//    val writer = BufferedWriter(OutputStreamWriter(System.`out`))
//
//    val n = reader.readLine().toInt()
//    var head:ListNode? = null
//    var sz = 0
//    for(i in 0 until n) {
//        val r = reader.readLine().trim()
//
//        if (r.length > 3 && r.substring(0, 3) == "Run") {
//            val name = r.split(' ', limit = 2).toMutableList()
//            sz++
//            if (head == null) head = ListNode(name[1])
//            else {
//                head.next = ListNode(name[1])
//                head.next?.prev = head
//                head = head.next
//            }
//            writer.write(head?.`val` + '\n')
//        }
//        else if(r.substring(0, 3) == "Alt" && head != null) {
//            val name = r.split('+').size - 1
//            //print("{${name} $sz}")
//            var p = head
//            if(name % sz != 0){
//                for (i in 0..<name % sz) {
//                    p = p?.prev
//                }
//                if (p?.prev != null) {
//                    p.prev?.next = p.next
//                }
//                if (p?.next != null) {
//                    p.next?.prev = p.prev
//                }
//                p?.next = null
//                p?.prev = head
//                head.next = p
//                head = head.next
//            }
//            writer.write(head?.`val` + '\n')
//        }
//        else println()
//
//    }
//    reader.close()
//    writer.close()
//
//}
