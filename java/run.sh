#!/bin/bash
# Library Management System - Startup Script

echo "🚀 Starting Library Management System..."
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"

# Check if Maven is available
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven not found. Please install Maven or use ./mvnw"
    exit 1
fi

# Build if needed
if [ ! -f "target/java-1.0-SNAPSHOT.jar" ]; then
    echo "📦 Building project..."
    ./mvnw clean package -DskipTests -q
    if [ $? -ne 0 ]; then
        echo "❌ Build failed"
        exit 1
    fi
    echo "✅ Build successful"
fi

echo "🎨 Launching UI..."
echo ""
echo "📖 Features:"
echo "   • Search books by barcode (101, 102)"
echo "   • Find members (M001, M002)"
echo "   • Issue & return books"
echo "   • View transaction logs"
echo ""
echo "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━"
echo ""

# Run the application
./mvnw javafx:run -q -DskipTests
