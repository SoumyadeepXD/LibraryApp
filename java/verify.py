#!/usr/bin/env python3
"""
Quick startup verification for Library Management System
"""

import os
import subprocess
import sys

def check_file(path, name):
    if os.path.exists(path):
        size = os.path.getsize(path)
        print(f"  ✅ {name:<30} {size:>8} bytes")
        return True
    else:
        print(f"  ❌ {name:<30} NOT FOUND")
        return False

def main():
    print("\n" + "="*60)
    print("  LIBRARY SYSTEM - PRE-LAUNCH VERIFICATION")
    print("="*60 + "\n")
    
    base = "/Users/soumyadeepxd/Developer/java_and_kotlin/java"
    all_ok = True
    
    print("📦 Build Artifacts:")
    all_ok &= check_file(f"{base}/target/java-1.0-SNAPSHOT.jar", "JAR Package")
    
    print("\n📁 Resources:")
    all_ok &= check_file(f"{base}/src/main/resources/ui/dashboard.fxml", "Dashboard Layout")
    all_ok &= check_file(f"{base}/src/main/resources/ui/books.fxml", "Books View")
    all_ok &= check_file(f"{base}/src/main/resources/ui/members.fxml", "Members View")
    all_ok &= check_file(f"{base}/src/main/resources/ui/issue_return.fxml", "Issue/Return View")
    all_ok &= check_file(f"{base}/src/main/resources/ui/logs.fxml", "Logs View")
    all_ok &= check_file(f"{base}/src/main/resources/ui/style.css", "CSS Styling")
    
    print("\n📚 Data Files:")
    all_ok &= check_file(f"{base}/src/main/resources/books.txt", "Books Database")
    all_ok &= check_file(f"{base}/src/main/resources/members.txt", "Members Database")
    all_ok &= check_file(f"{base}/src/main/resources/logs.txt", "Transaction Logs")
    
    print("\n📄 Documentation:")
    all_ok &= check_file(f"{base}/README.md", "README")
    all_ok &= check_file(f"{base}/FIXES_APPLIED.md", "Fixes Summary")
    
    if all_ok:
        print("\n" + "="*60)
        print("✅ ALL SYSTEMS GO - READY TO LAUNCH!")
        print("="*60)
        print("\n🚀 Start the app with:")
        print("   cd /Users/soumyadeepxd/Developer/java_and_kotlin/java")
        print("   ./mvnw javafx:run -DskipTests")
        print("\n")
        return 0
    else:
        print("\n" + "="*60)
        print("❌ MISSING FILES - CHECK ABOVE")
        print("="*60 + "\n")
        return 1

if __name__ == "__main__":
    sys.exit(main())
