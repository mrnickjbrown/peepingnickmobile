package com.peepingnick.android

object CsvUtils {
    @JvmStatic
    fun jsonMatchesToCsv(json: String): String {
        try {
            val sb = StringBuilder()
            sb.append("reference,target,ssim,hash8_hamming,hash16_hamming,ncc_score,confidence,matched,bbox_x,bbox_y,bbox_w,bbox_h\n")
            val obj = org.json.JSONObject(json)
            val arr = obj.getJSONArray("matches")
            for (i in 0 until arr.length()) {
                val o = arr.getJSONObject(i)
                val ref = o.optString("reference")
                val tgt = o.optString("target")
                val ssim = o.optDouble("ssim")
                val h8 = o.optInt("hash8_hamming")
                val h16 = o.optInt("hash16_hamming")
                val ncc = o.optDouble("ncc_score")
                val conf = o.optDouble("confidence")
                val matched = o.optBoolean("matched")
                val bbox = o.optJSONObject("bbox") ?: org.json.JSONObject()
                val bx = bbox.optInt("x")
                val by = bbox.optInt("y")
                val bw = bbox.optInt("w")
                val bh = bbox.optInt("h")
                fun esc(s: String) = "\"" + s.replace("\"","\"\"") + "\""
                sb.append(listOf(esc(ref), esc(tgt), ssim, h8, h16, ncc, conf, matched, bx, by, bw, bh).joinToString(","))
                sb.append("\n")
            }
            return sb.toString()
        } catch (e: Exception) {
            return "reference,target,ssim,hash8_hamming,hash16_hamming,ncc_score,confidence,matched,bbox_x,bbox_y,bbox_w,bbox_h\n"
        }
    }
}