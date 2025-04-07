// ECMS.cpp : Defines the entry point for the application.
//

#include "ECMS.h"
#include "Window.h"
#include "Mixer.h"

int main()
{
	ECMS::Mixer mixer(10);

	UI::Window* mainWindow = new UI::Window("ECMS v0.1", 1366, 768);
	mainWindow->show();

	return Fl::run();
}