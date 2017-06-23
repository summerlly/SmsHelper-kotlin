package tech.summerly.smshelper.extention

import android.content.Context
import android.os.Build
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import tech.summerly.smshelper.AppContext

/**
 * <pre>
 *     author : YangBin
 *     e-mail : yangbinyhbn@gmail.com
 *     time   : 2017/5/21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
fun Any.log(message: String?, tag: String = this.javaClass.name.replace("tech.summerly.smshelper", "")) {
    if (false) {// close log output
        Log.i(if (tag.isEmpty()) "empty" else tag, message)
    }
}

fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

@Suppress("DEPRECATION")
fun color(@ColorRes id: Int, context: Context = AppContext.instance): Int {
    if (Build.VERSION.SDK_INT >= 23) {
        return context.getColor(id)
    } else {
        return context.resources.getColor(id)
    }
}

fun string(@StringRes stringId: Int) = AppContext.instance.getString(stringId)!!

fun string(@StringRes stringId: Int, vararg formatArgs: Any) = AppContext.instance.getString(stringId, formatArgs)!!


fun StringBuilder.clear() {
    if (isEmpty()) {
        return
    }
    delete(0, length)
}