


import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.kotlin.thirdproject.UserModel


class Users(    /// we must implement the oncreat fun + onUpgrade by clicking on alt on the class
    context: Context
) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATA_BASE_VER) {   //needs 4 things

    companion object {

        // inside the class   data base info
        const val DATABASE_NAME = "user_database"
        const val DATA_BASE_VER = 1 /// كان واحد بس بعد ما اضفنا كولوم جديد اضطرينا نغيره ل 2

        ///// TABLE INFO
        const val TABLE_NAME = "user_table"
        const val COL_EMAIL = "email"
        const val COL_PHN = "phone"
        const val COL_NAME = "name"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val initTable =
            "CREATE TABLE $TABLE_NAME ($COL_PHN TEXT PRIMARY KEY, $COL_EMAIL TEXT, $COL_NAME TEXT)"
        db?.execSQL(initTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        db?.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    fun AddUser(usr :UserModel) {

        val db = writableDatabase
        val values = ContentValues()

        values.put(COL_PHN, usr.phoneNum)
        values.put(COL_EMAIL, usr.email)
        values.put(COL_NAME,usr.name)
        db.insert(TABLE_NAME, null, values)

    }

     fun getUSER(phoneNum: String) : UserModel? {  //// موع القيمة المرجعة بتكون يوزر مودل
         val db = readableDatabase
         val query = "SELECT * FROM $TABLE_NAME WHERE $COL_PHN= '$phoneNum"
         val cursor = db.rawQuery(query,null)  /// raw query هي الامر للداتا بيس
         var user_info :UserModel? = null

         if (cursor.count > 0){
             cursor.moveToFirst() /// sure that i have results
             val phoneNum = cursor.getString(cursor.getColumnIndex(COL_PHN))
             val email = cursor.getString(cursor.getColumnIndex(COL_EMAIL))
             val name = cursor.getString(cursor.getColumnIndex(COL_NAME))

             user_info =UserModel(phoneNum = phoneNum , email = email,name=name )
         }
         return user_info

     }
 }





