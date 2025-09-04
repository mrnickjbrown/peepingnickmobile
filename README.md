
# PeepingNick (Offline)

An offline Android app that matches **reference images** against **target photos** (or a target **ZIP**) to find products/pallets/retail stands. 
Shows **PASS/FAIL**, **confidence**, draws **bounding boxes**, and lets you **export CSV** and **annotated previews**.

## Build (GitHub Actions, Debug APK)
1. Create a GitHub repo and push this project.
2. Open the **Actions** tab → run **Build Debug APK**.
3. Download the artifact `peepingnick-app-debug` → `app-debug.apk`.

## On-Device Usage
- **Select Reference Images** (or take a photo).
- **Per-Reference Thresholds** (optional).
- **Select Target Images** or **Select Target ZIP**.
- Adjust **Match Threshold** and **SSIM weight** (NCC = 1 - SSIM).
- **Run Match**, view PASS/FAIL with confidence & bounding box.
- **Export CSV** and **Save Annotated Previews** under the app’s external files directory.

## Notes
- All processing is **offline**, on-device via **Chaquopy (Python)** with **NumPy** + **Pillow**.
- If you later want a TFLite detector, the Python has a hook in `matcher.py`.
